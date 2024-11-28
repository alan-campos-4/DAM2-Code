import os
from git import Repo

bare_repo = Repo.init(os.path.join(rw_dir, "bare-repo"), bare=True)
assert bare_repo.bare