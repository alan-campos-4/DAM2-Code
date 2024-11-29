import os
import sys
import git


def print_repo_state(num, path):
    if os.path.exists(path):
        try:
            repo = git.Repo(path)
            name = os.path.basename(os.path.normpath(path))
            if repo.git.execute("git status -uno").find("nothing to commit")==-1:
                state = "Changed"
            else:
                state = "Up to date"
            print(f" {num}.) {name} | {state}")

        except git.exc.InvalidGitRepositoryError:
            print("Repository not found")
        except git.exec.GitCommandError:
            print("Invalid command")
    else:
        print("Path not found")


def list_repos():
    print("\n--- Repository List ---\n")
    for i, arg in enumerate(sys.argv):
        if i>0:
            print_repo_state(i, arg)


if __name__ == "__main__":
    os.system('cls')
    list_repos()



#git status -uno
#git show-branch