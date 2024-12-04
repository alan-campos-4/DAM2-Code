import itertools
import os
import sys
import threading
import git
import time



def clear():
    os.system('cls' if os.name == 'nt' else 'clear')

def animated_loading():
    chars = "/—\|"
    while True:
        for char in chars:
            sys.stdout.write('\r'+char)
            time.sleep(.1)
            sys.stdout.flush()


def delete_line():
    sys.stdout.write("\033[1A\x1b[2K")
    sys.stdout.flush()



entries = []
names = []
states = []
paths = []

def list_repos():
    print("\n--- Repository List ---\n")
    
    process = threading.Thread(target=animated_loading)
    process.start()

    for i, arg in enumerate(sys.argv):
        if i>0:
            if os.path.exists(arg):
                try:
                    repo = git.Repo(arg)
                    repo_name = repo.remotes.origin.url.split('.git')[0].split('/')[-1]
                    repo.git.execute("git remote update")
                    result = repo.git.execute("git status -uno")

                    if result.find("nothing to commit")!=-1:
                        if result.find("git pull")!=-1:
                            state = "Pull available"
                        elif result.find("git push")!=-1:
                            state = "Push ready"
                        else:
                            state = "Up to date"
                    else:
                        state = "Changed"
                    
                    entries.append(i)
                    names.append(repo_name)
                    states.append("["+state+"]")
                    paths.append(arg)

                except git.exc.InvalidGitRepositoryError:
                    print(f" {i}.) Repository not found")
                except git.exc.GitCommandError:
                    print(f" {i}.) Error in command")
            else:
                print(f" {i}.) Path not found")
    
    process.join()
    print_menu()


def print_menu():
    print("\n")
    max_b = max(states, key=len)
    max_c = max(names, key=len)
    for (a, b, c, d) in zip(entries, states, names, paths):
        while len(b) < len(max_b):
            b += str(" ")
        while len(c) < len(max_c):
            c += str(" ")
        print(f" {a}.) {b} {c} | {d}")
    print(" 0.) Exit.")   


def access_repo(opt:str):
    for i, arg in enumerate(sys.argv):
        if i==int(opt):
            try:
                repo = git.Repo(arg)
                folder_name = os.path.basename(os.path.normpath(arg))
                repo_name = repo.remotes.origin.url.split('.git')[0].split('/')[-1]
                print(f"\n\nRepository {repo_name} in {folder_name} accessed.")
            except git.exc.InvalidGitRepositoryError:
                print("Repository not found")



if __name__ == "__main__":

    opt = "1"
    while opt!="0":

        clear()
        list_repos()
        opt = input("\nChoose a repo: ")

        if opt=="0":
            print("\nExiting...")
        elif opt in entries:
            access_repo(opt)
            input("Press Enter to continue...")
        else:
            print("Option not valid")
            input("Press Enter to continue...")



#git status -uno
#git show-branch