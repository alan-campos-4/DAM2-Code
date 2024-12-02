import os
import sys
import git


def list_repos():
    print("\n--- Repository List ---\n")
    for i, arg in enumerate(sys.argv):
        if i>0:
            if os.path.exists(arg):
                try:
                    repo = git.Repo(arg)
                    foldername = os.path.basename(os.path.normpath(arg))
                    if repo.git.execute("git status -uno").find("nothing to commit")==-1:
                        state = "Changed"
                    else:
                        state = "Up to date"
                    print(f" {i}.) {foldername}. [ {state} ]")
                except git.exc.InvalidGitRepositoryError:
                    print("Repository not found")
                except git.exec.GitCommandError:
                    print("Invalid command")
            else:
                print("Path not found")
    print(" 0.) Exit.")


def access_repo(opt:str):
    for i, arg in enumerate(sys.argv):
        if i==int(opt):
            try:
                repo = git.Repo(arg)
                print(f"\n\nRepository in {arg} accessed.")
            except git.exc.InvalidGitRepositoryError:
                print("Repository not found")



if __name__ == "__main__":

    opt = "1"
    while opt!="0":

        os.system('cls')
        list_repos()
        opt = input("\nChoose a repo: ")

        if opt!="0":
            access_repo(opt)
            input("Press Enter to continue...")

#git status -uno
#git show-branch