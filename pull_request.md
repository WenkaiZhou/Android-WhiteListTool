# We are a team

1. `fork`到自己空间

    <img src="https://raw.githubusercontent.com/xuehuayous/Android-WhiteListTool/master/art/fork.png" width="300" />
    
2. `clone`自己空间的库到本地
    ```
    git clone https://github.com/`your github name`/Android-WhiteListTool

    ```
    
3. 进入项目目录

    ```
    cd Android-WhiteListTool
    ```
    
4. 切换到`dev`分支

    ```
    git checkout -b dev
    ```
    
5. 修改内容

6. 提交修改内容到本地

    ```
    git commit -am "描述内容"
    ```
    
7. 获取原库最新代码

    ```
    git remote add upstream https://github.com/xuehuayous/Android-WhiteListTool
    git fetch upstream
    ```
    
8. `merge`原库最新代码

    ```
    git merge upstream/master
    ```
    
9. `push`到你的github

    ```
    git push origin dev
    ```
    
10. 到你的github中点击`pull request`，添加说明后提交。

    <img src="https://raw.githubusercontent.com/xuehuayous/Android-WhiteListTool/master/art/pull_request.png" width="700" />
    <img src="https://raw.githubusercontent.com/xuehuayous/Android-WhiteListTool/master/art/pull_request_2.png" width="500" />
   