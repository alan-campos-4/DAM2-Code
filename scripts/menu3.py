from pymenu import Menu

menu = Menu('Menu title')
menu.add_option("Repo 1", lambda: print("Option 1"))
menu.add_option("Repo 2", lambda: print("Option 2"))
menu.add_option("Repo 3", lambda: print("Option 3"))
menu.show()
