import os
import sys


def pull():
    opt = input("\n\tAre you sure you want to pull changes? (y/n): ")
    if (opt=='y' or opt=='y'):
        os.system('cmd /c git pull')


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
            option = '1'
            os.system('cls')
            if os.path.isdir(arg):
                os.chdir(arg)
                if os.path.isdir('./.git'):
                    while option!='0':
                        print(f"\n------ Repo {i}/{len(sys.argv)-1} in {arg} ------\n")
                        os.chdir(arg)
                        os.system('cmd /c git status')

                        print("\n\tWhat do you want to do?: ")
                        print("\t\t1. Stage changes.")
                        print("\t\t2. Save changes and commit.")
                        print("\t\t3. Save changes, commit and push.")
                        print("\t\t4. Pull last commit.")
                        if i+1 == len(sys.argv):
                            print("\t\t0. End script.")
                        else:
                            print("\t\t0. Go to next repo.")
                        option = input("\tChoose an option: ")
                        
                        if (option=='1'):
                            gitAdd()
                        elif (option=='2'):
                            gitComm()
                        elif (option=='3'):
                            gitPush()
                        elif (option=='4'):
                            pull()
                        elif (option=='0'):
                            print("")
                        else:
                            print("Not valid input.")
                            input("Press Enter to continue...")
                else:
                    print(f"This directory {arg} is not a repository.")
                    input("Press Enter to continue...")
            else:
                print(f"This directory {arg} doesn't exist.")
                input("Press Enter to continue...")

