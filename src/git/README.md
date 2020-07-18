
### git 命令


##### 初始化一个Git仓库

    什么叫版本库： 一个目录，这个目录里面的所有文件都可以被Git管理起来。
    
    初始化git仓库： git init
    
    1. 添加文件到暂存区 git add <file>
    2. 提交文件到Git仓库 git commit -m <message>


##### git 基础命令

    git status
    
    查看工作区、暂存区转态
    
    git add [file name]：
    将工作区的信息（变化）添加到暂存区
    
    
    git commit -m "msg" [file name]
    将暂存区的内容提交到本地库
    
    git log
    查看本地库更新历史记录
    
    git log --oneline
    查看本地库更新历史记录（简化版）
    
    git reflog
    查看本地库更新历史记录（展现HEAD指针）
    
    git diff HEAD -- readme.txt
    查看工作区和版本库里面最新版本的区别
    
    
    git add .
    一次性将工作区的变更
    
    git commit -am"msg"
    
    
    用git log --graph命令可以看到分支合并图。
    
    
    git remote
    要查看远程库的信息
   
    git remote -v
    
    git push origin <branch-name>
    
    git push origin master
    推送master分支
    
    git push origin dev
    
    拉取远程分支：解决冲突。
    拉取远程分支自动合并到本地
    git pull <remote> <branch>

    和上相同，但是它需要手动合并
    git fetch <remote> <branch>

##### 版本的前进和后退管理
    
    
   
    在历史版本之间穿梭，使用命令 git reset --hard commit_id
    
    HEAD指向的版本就是当前版本。  == 》  git reset --hard HEAD^
    
    HEAD^ 代表上一版本， HEAD^^ 上上；  HEAD~100 上一百个版本。
    
    穿梭前，用git log可以查看提交历史，以便确定要回退到哪个版本
    要重返未来，用git reflog查看命令历史，以便确定要回到未来的哪个版本。
    
    
    git reflog 前进和回退的操作都会记录下来。 



#### 撤销修改

 分为三种情况：

     一： 没有add
        修改的内容没有同步到暂存区时，可以撤销修改； 两种方法
     
     1）git restore <file>
     2）git checkout -- <file>
          
     
     二：添加到了暂存区域，没有同步到仓库。
        
       两种方法： 
        
       1）先执行， git restore --staged <file>， 将仓库里的拉到暂存区
         再执行情况一命令。
         
       2）先执行，git reset HEAD <file>；再回到情况1 
       
     三：添加到了版本库；只能做版本回退。
     

#### 删除文件

    ljs@DESKTOP-M89CNA3 MINGW64 ~/Desktop/gitl (master)
    $ rm -rf a.txt
    
    ljs@DESKTOP-M89CNA3 MINGW64 ~/Desktop/gitl (master)
    $ git status
    On branch master
    Changes not staged for commit:
      (use "git add/rm <file>..." to update what will be committed)
      (use "git restore <file>..." to discard changes in working directory)
            deleted:    a.txt
    
    no changes added to commit (use "git add" and/or "git commit -a")
    

    一是确实要从版本库中删除该文件，那就用命令git rm删掉，并且git commit
    
    git add .
    git commit -m "shanchu"
    
    
#### 分支管理

    查看分支：git branch
    
    创建分支：git branch <name>
    
    切换分支：git checkout <name>
    
    创建+切换分支：git checkout -b <name>
    
    合并某分支到当前分支：git merge <name>
    
    删除分支：git branch -d <name>
    



#### 远程仓库


    
    …or create a new repository on the command line
    
    echo "# andshare" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git remote add origin https://github.com/jinshengli/andshare.git
    git push -u origin master
                    
                
                
    …or push an existing repository from the command line
    
    git remote add origin https://github.com/jinshengli/andshare.git
    git push -u origin master



1. 关联一个远程库


    git remote add origin https:xxx
    
    关联后，第一次推送master分支内容； git push -u origin master
    
    此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送最新修改；
    
    
    删除本地指定的远程地址：
    git remote remove <remote>


2. 从远程仓库克隆


    git clone 远程仓库地址   // 默认克隆远程仓库的master分支
    
    克隆完，你先切换远程仓库不同的分支，git checkout -b dev origin/dev
    
    在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
    
    拉取远程的一个分支： git clone -b 远程分支名称 仓库地址


3. 创建一个远程参考的分支


     git push origin(仓库名 key) 分支名


4. 删除一个远程参考的分支


    git push origin -d 分支名





### git 目录说明

    工作区： 任意目录下，我们开发代码的目录
    暂存区域：工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。
    版本库（Repository）：工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。




因此，多人协作的工作模式通常是这样：

    首先，可以试图用git push origin <branch-name>推送自己的修改；
    
    如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
    
    如果合并有冲突，则解决冲突，并在本地提交；
    
    没有冲突或者解决掉冲突后，再用git push origin <branch-name>推送就能成功！
    
    如果git pull提示no tracking information，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream-to <branch-name> origin/<branch-name>。
    
    这就是多人协作的工作模式，一旦熟悉了，就非常简单。