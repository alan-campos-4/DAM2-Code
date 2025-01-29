import os
import sys
import git # type: ignore


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

def read_from_file():
    RepoList.clear()
    with open('repo states.txt', 'r') as file:
        for line in file:
            parts = line.split(',')
            RepoList.append(Repository(parts[0], parts[1], parts[2], parts[3]))

def write_to_file(): ############
    with open('repo states.txt', 'rw') as file:
        for Repository in RepoList:
            file.append("")

def print_menu():
    print("\n----- GitHub Repositories -----\n")
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
        print(f" - {repo.name} ", end='')
        print_diff(maxlen2, len(repo.name))
        print(f" | {repo.state} ", end='')

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


def open_repository(num):
    for Repo in RepoList:
        if Repo.id == num:
            print(f"You are in repo {Repo.id}")
    input("Press Enter to continue...")



if __name__ == "__main__":
    
    if connection_available():
        opt = "1"
        while opt!="0":
            clear()
            if (RepoList==[]):
                read_from_file()
            print_menu()
            opt = input("\nSelect a repository: ")
            if opt=="0":                print("\nExiting...")
            elif opt=="U" or opt=="u":  write_to_file()
            elif opt in get_id_list():  open_repository(opt)
            else:                       print("Option not valid. Press Enter to return...")


