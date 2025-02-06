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
        #repo = git.Repo(sys.argv[1])
        #repo.git.execute("git status -uno")
        #print("Connection available. Starting script.")
        return True
    except OSError:
        input("Connection not available. Try again...")
        pass
    except git.exc.InvalidGitRepositoryError:
        input("Repository checked is invalid...")
        pass
    return False

def date_for_commit():
    return datetime.datetime.now().strftime("%d")+"/"+datetime.datetime.now().strftime("%m")



class Repository:
    id:int
    dir:str
    name:str
    def __init__(self, id, dir, name):
        self.id = id
        self.dir = dir
        self.name = name

RepoList = []
filepath = 'repo states.txt'


def read_from_file():
    RepoList.clear()
    with open(filepath, 'r') as file:
        for line in file:
            parts = line.split(',')
            RepoList.append(Repository(parts[0], parts[1], parts[2]))
    file.close()


def id_list():
    ids = []
    for Repo in RepoList:
        ids.append(Repo.id)
    return ids


def list_repos():
    maxlen1 = 0
    for repo in RepoList:
        if len(repo.dir)>maxlen1:
            maxlen1 = len(repo.dir)
    for repo in RepoList:
        print(f"\t{repo.id}.) {repo.name} | {repo.dir} ")


def open_repo(id):
    for repo in RepoList:
        if id==repo.id:
            try:
                repo_obj = git.Repo(repo.dir)
                folder_name = os.path.basename(os.path.normpath(repo.dir))
                print(f"You have accessed the {repo.name} repository in {folder_name}")
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
                print(f"State: {new_state}")

                option = input("What do you want to do?: ")

                if option=="1":
                    print("")
                elif option=="2":
                    print("")
                else:
                    print("")

            except git.exc.InvalidGitRepositoryError:
                print(f"Repository {repo.dir} not found")




if __name__ == "__main__":
    
    if connection_available():
        opt = "1"
        while opt!="0":
            clear()
            read_from_file()
            
            print(f"\n----- GitHub Repositories ----- {date_for_commit()}\n")
            list_repos()
            opt = input("\nSelect a repository: ")
            if opt!='':
                if opt=="0":            print("\nExiting...")
                elif opt in id_list():  open_repo(opt)
                else:                   print("Option not in range.")
            else: print("Option not selected.")

            input("Press Enter to return...")

