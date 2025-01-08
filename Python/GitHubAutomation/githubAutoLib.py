import os
import sys
import git



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


numbers = []
names = []
states = []
paths = []


def reload_repos():
    numbers.clear()
    names.clear()
    states.clear()
    paths.clear()
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
                    repo.close()
                    numbers.append(i)
                    names.append(repo_name)
                    states.append(state)
                    paths.append(arg)
                except git.exc.InvalidGitRepositoryError:
                    print(f" {i}.) Repository {arg} not found")
                except git.exc.GitCommandError:
                    print(f" {i}.) Error in command")
            else:
                print(f" {i}.) Path {arg} not found")



def open_main_menu():
    states1 = []
    for st in states:
        states1.append("["+st+"]")
    max_st = max(states1, key=len)
    max_nm = max(names, key=len)
    for (a, b, c, d) in zip(numbers, states1, names, paths):
        while len(b) < len(max_st):
            b += str(" ")
        while len(c) < len(max_nm):
            c += str(" ")
        print(f" {a}.) {b} | {c} | {d}")
    print(" U.) Update.")
    print(" 0.) Exit.")



def open_repository_menu(opt:str):
    for i, arg in enumerate(sys.argv):
        if i==int(opt):
            try:
                repo = git.Repo(arg)
                folder_name = os.path.basename(os.path.normpath(arg))
                repo_name = repo.remotes.origin.url.split('.git')[0].split('/')[-1]
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
                    elif option in str(opt_nums):
                        if option == '1':   git_command(arg, "Print", "git status")
                        elif option == '2': git_command(arg, "Changes have been retreived from origin.", "git pull")
                        elif option == '3': git_command(arg, "Recent changes have been discarded.", "git stash")
                        elif option == '4':
                            commit_name = input("\nWhat is the name of the commit?: ")
                            git_command(arg, "Changes have been saved.", "git add --all", "git commit -m \""+commit_name+"\"")
                        elif option == '5':
                            commit_name = input("\nWhat is the name of the commit?: ")
                            git_command(arg, "Changes have been saved and pushed to origin.", 
                                        "git add --all", "git commit -m \""+commit_name+"\"", "git push")
                        reload_repos()
                        clear()
                        option = "0"
                    else:
                        input("Not valid input. Press Enter to return...")
                        i=1
                        while i<len(opt_nums)+5:
                            delete_line()
                            i += 1
                repo.close()
            except git.exc.InvalidGitRepositoryError:
                print(f"Repository {arg} not found")



def git_command(arg, message, *commands):
    repo = git.Repo(arg)
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
            if (numbers == []):
                reload_repos()
            
            print("\n--- Repository List ---\n")
            open_main_menu()
            opt = input("\nChoose a repo: ")

            if opt=="U" or opt=="u":
                reload_repos()
            elif opt=="0":
                print("\nExiting...")
            elif int(opt) in numbers:
                open_repository_menu(opt)
            else:
                print("Option not valid. Press Enter to return...")


