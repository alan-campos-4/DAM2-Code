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




if __name__ == "__main__":
    
    if connection_available():
        print("Option not valid. Press Enter to return...")



