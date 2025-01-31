import os
import sys
import git # type: ignore
import datetime


def clear():
    os.system('cls' if os.name == 'nt' else 'clear')

def delete_line():
    print("\033[1A\x1b[2K", end="")

def connection_available():
    try:
        repo = git.Repo(sys.argv[1])
        repo.git.execute("git status -uno")
        print("Connection available. Starting script.")
        return True
    except OSError:
        print("Connection not availabel. Try again.")
        pass
    except git.exc.InvalidGitRepositoryError:
        print("Repository checked is invalid.")
        pass
    return False



class Repository:
    id:int
    dir:str
    name:str
    state:str
    def __init__(self, id, dir, name, state):
        self.id = id
        self.dir = dir
        self.name = name
        self.state = state

RepoList = []
filepath = 'repo states.txt'


def read_from_file():
    RepoList.clear()
    with open(filepath, 'r') as file:
        for line in file:
            parts = line.split(',')
            RepoList.append(Repository(parts[0], parts[1], parts[2], parts[3]))
    file.close()

def write_to_file(id):
    for Repo in RepoList:
        if Repo.id==int(id) or id==-1:
            repo_obj = git.Repo(Repo.dir)
            repo_obj.git.execute("git remote update")
            result = repo_obj.git.execute("git status -uno")
            new_state=""
            if result.find("nothing to commit")!=-1:
                if result.find("git pull")!=-1:
                    new_state = "Pull available"
                elif result.find("git push")!=-1:
                    new_state = "Push ready"
                else:
                    new_state = "Up to date"
            else:
                new_state = "Changed"
            repo_obj.close()
            
            with open(filepath, 'r') as fr:
                lines = fr.readlines()
            fr.close()
            with open(filepath, 'w') as fw:
                for line in lines:
                    parts = line.split(',')
                    if parts[0]==id:
                        fw.write(f"{Repo.id},{Repo.dir},{Repo.name},{new_state}")
                    else:
                        fw.write(line)
            fw.close()



def print_diff(maxlen, varlen):
    dif = maxlen-varlen
    while dif>0:
        print(" ", end='')
        dif -= 1


def get_id_list():
    id_list = []
    for Repo in RepoList:
        id_list.append(Repo.id)
    return id_list


def date_for_commit():
    return datetime.datetime.now().strftime("%d")+"/"+datetime.datetime.now().strftime("%m")


def open_repository(num):
    for Repo in RepoList:
        if Repo.id == num:
            try:
                repo_object = git.Repo(Repo.dir)
                folder_name = os.path.basename(os.path.normpath(Repo.dir))
                repo_name = repo_object.remotes.origin.url.split('.git')[0].split('/')[-1]
                print(f"\n\nRepository {repo_name} in {folder_name} accessed.")
                print("\n\tWhat do you want to do?: ")
                opt_nums = ["1", "2", "3", "4", "5"]
                repo_options = ["Check status", "Pull last commit", 
                                "Discard changes", "Save changes and commit", "Save changes, commit and push"]
                option = 1
                while option!="0":
                    for num, name in zip(opt_nums, repo_options):
                        print(f"\t\t {num}. {name}.")
                    print("\t\t 0. Return.")
                    option = input("\tChoose an option: ")
                    if option=='0':
                        input("Exiting. Press Enter to continue...")
                    elif option in str(opt_nums) or option=='55':
                        if option == '1':   git_command(Repo.dir, "Print", "git status")
                        elif option == '2': git_command(Repo.dir, "Changes have been retreived from origin.", "git pull")
                        elif option == '3': git_command(Repo.dir, "Recent changes have been discarded.", "git stash")
                        elif option == '4':
                            commit_name = input("\nWhat is the name of the commit?: ")
                            git_command(Repo.dir, "Changes have been saved.", "git add --all", "git commit -m \""+commit_name+"\"")
                        elif option == '5':
                            commit_name = input("\nWhat is the name of the commit?: ")
                            git_command(Repo.dir, "Changes have been saved and pushed to origin.", 
                                        "git add --all", "git commit -m \""+commit_name+"\"", "git push")
                        elif option == '55':
                            git_command(Repo.dir, "Changes have been saved and pushed to origin.", 
                                        "git add --all", f"git commit -m \"{date_for_commit()}\"", "git push")
                        if option != '1':
                            write_to_file(Repo.id)
                        clear()
                        option = "0"
                    else:
                        input("Not valid input. Press Enter to return...")
                        i=1
                        while i<len(opt_nums)+5:
                            delete_line()
                            i += 1
                repo_object.close()
            except git.exc.InvalidGitRepositoryError:
                print(f"Repository {Repo.dir} not found")


def git_command(dir, message, *commands):
    repo = git.Repo(dir)
    if (message=="Print"):
        for comm in (commands):
            result = repo.git.execute(comm)
            print(result)
    else:
        for comm in (commands):
            repo.git.execute(comm)
        print(message)
    input("Press Enter to continue...")
    repo.close()




if __name__ == "__main__":
    
    if connection_available():
        opt = "1"
        while opt!="0":
            clear()
            read_from_file()
            
            print(f"\n----- GitHub Repositories ----- {date_for_commit()}\n")
            maxlen1 = 0
            maxlen2 = 0
            for repo in RepoList:
                if len(repo.dir)>maxlen1:
                    maxlen1 = len(repo.dir)
                if len(repo.name)>maxlen2:
                    maxlen2 = len(repo.name)
            for repo in RepoList:
                print(f"\t{repo.id}.) {repo.dir}", end='')
                print_diff(maxlen1, len(repo.dir))
                print(f" | {repo.name} ", end='')
                print_diff(maxlen2, len(repo.name))
                print(f" | {repo.state} ", end='')
            print("\n\tU.) Update.")
            print("\t0.) Exit.")

            opt = input("\nSelect a repository: ")

            if opt=="0":                print("\nExiting...")
            elif opt=="U" or opt=="u":  write_to_file(-1)
            elif opt in get_id_list():  open_repository(opt)
            else:                       print("Option not valid. Press Enter to return...")


