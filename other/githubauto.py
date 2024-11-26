import os
import sys


def pull():
    opt = input("\n\tAre you sure you want to pull changes? (y/n): ")
    if (opt=='y' or opt=='y'):
        os.system('cmd /c git pull')

def gitStash():
    opt = input("\n\tAre you sure you erase your changes? (y/n): ")
    if (opt=='y' or opt=='y'):
        os.system('cmd /c git stash')

def gitAdd():
    os.system('cmd /c git add --all')

def gitComm():
    gitAdd()
    commName = input("\n\tName for the new commit: ")
    os.system(f'cmd /c git commit -m "{commName}"')

def gitPush():
    gitComm()
    os.system('cmd /c git push')


if __name__ == "__main__":

    for i, arg in enumerate(sys.argv):
        if i>0:
            if os.path.isdir(arg):
                os.chdir(arg)
                if os.path.isdir('./.git'):
                    option = '1'
                    while option!='0':
                        
                        os.system('cls')
                        print(f"\n------ Repo {i}/{len(sys.argv)-1} in {arg} ------\n")
                        os.system('cmd /c git status')
                        print("\n\tWhat do you want to do?: ")
                        print("\t\t1. Pull last commit.")
                        print("\t\t2. Discard changes.")
                        print("\t\t3. Update changes.")
                        print("\t\t4. Save changes and commit.")
                        print("\t\t5. Save changes, commit and push.")
                        print("\t\t6. Pull last commit.")
                        if (i+1 < len(sys.argv)):
                            print("\t\t5. Go to next repo.")
                        print("\t\t0. End script.")
                        option = input("\tChoose an option: ")
                        
                        if (option=='1'):   gitAdd()
                        elif (option=='2'): gitComm()
                        elif (option=='3'): gitPush()
                        elif (option=='4'): pull()
                        elif (option=='5' or option=='0'):
                            break
                        else:
                            print("Not valid input.")
                            input("Press Enter to continue...")
                else:
                    print(f"This directory {arg} is not a repository.")
                    input("Press Enter to continue...")
            else:
                print(f"This directory {arg} doesn't exist.")
                input("Press Enter to continue...")
            
            if (option=='0'):
                break

