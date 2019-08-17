---
title: Switch multiple accounts with Github (Mac OSX)
layout: post
---

##  Summary

In this post, we document key steps to switch Switch multiple accounts with git and github on Mac OSX.

## Github related settings
- First create different ssh keys for different accounts
```
ssh-keygen -t rsa -C "your_email@youremail.com"
```

- Use following commands to list, add, and delete ssh keys
```
ssh-add -l 
ssh-add -D 
ssh-add ~/.ssh/id_rsa_techbrave (change it to the name assotiate with the account)
```

- Update github account with the corresponding ssh public key, [link](https://help.github.com/en/articles/adding-a-new-ssh-key-to-your-github-account)


- Download remote git repo:
```
git clone https://github.com/user/repo-name.git
```

## What I found useful after following above steps
- Unset global git user, and set a new user
  - `git config --global --unset-all user.name`
  - `vim ~/.gitconfig`
  - `git config user.name "Bob"`
- Unset "old" ssh key 
  - `ssh-add -D`, `ssh-add ~/.ssh/id_rsa`
- **Most Importantly**, clean your keychain 
```
Open up Keychain access, click on All Items and search for git. You will get some items like this:

![Screenshot]({{ '/images/Screenshot-2018-08-17.png' }})

Delete them. Now try to push the repo and git will ask you to write password for the user and you will be good to go.
```

# Useful references
- [Multiple SSH Keys settings for different github account](https://gist.github.com/jexchan/2351996)
- [Mac OS switch git user at terminal](https://superuser.com/questions/1064197/how-to-switch-git-user-at-terminal)
- [Handling Multiple Github Accounts on MacOS](https://gist.github.com/Jonalogy/54091c98946cfe4f8cdab2bea79430f9)
- [How to manage multiple GitHub accounts on a single machine with SSH keys](https://www.freecodecamp.org/news/manage-multiple-github-accounts-the-ssh-way-2dadc30ccaca/)