import os
import sys
import git


options = [""]


def list_repos():
    print("\n--- Repository List ---\n")
    for i, arg in enumerate(sys.argv):
        if i>0:
            if os.path.exists(arg):
                try:
                    repo = git.Repo(arg)
                    foldername = os.path.basename(os.path.normpath(arg))
                    repo.git.execute("git remote update")
                    result = repo.git.execute("git status -uno")
                    if result.find("nothing to commit")!=-1:
                        if result.find("git pull")!=-1:
                            state = "Pull available"
                        else:
                            state = "Up to date"
                    else:
                        state = "Changed"
                    print(f" {i}.) {foldername}. [ {state} ]")
                    options.append(i)
                except git.exc.InvalidGitRepositoryError:
                    print(f" {i}.) Repository not found")
                except git.exc.GitCommandError:
                    print(f" {i}.) Error in command")
            else:
                print(f" {i}.) Path not found")
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

        os.system('cls')
        list_repos()
        opt = input("\nChoose a repo: ")

        if opt in options:
            access_repo(opt)
            input("Press Enter to continue...")



#git status -uno
#git show-branch