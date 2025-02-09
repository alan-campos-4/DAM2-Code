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



class Repository: #(git.Repo) :
    id:int
    dir:str
    def __init__(self, id, dir):
        self.id = id
        self.dir = dir

RepoList = []
filepath = sys.argv[1]


def read_from_file():
    RepoList.clear()
    i = 1
    with open(filepath, 'r') as file:
        for line in file:
            RepoList.append(Repository(i, line))
            i = i + 1
    file.close()


def id_list():
    ids = []
    for Repo in RepoList:
        ids.append(Repo.id)
    return ids


def list_repos():
    for repo in RepoList:
        try:
            repo_obj = git.Repo(repo.dir)
            repo_name = repo_obj.remotes.origin.url.split('.git')[0].split('/')[-1]
            print(f"\t{repo.id}.) {repo_name} | {repo.dir} ", end='')
            repo_obj.close()
        except git.exc.NoSuchPathError:
            print(f"\t{repo.id}.) No such path as {repo.dir}", end='')


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

