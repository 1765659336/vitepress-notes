# rebase

## 修改历史提交的commit信息
1. git log 找到要修改的commit记录，复制要修改的下一条版本号
2. git rebase -i 版本号
3. 按 "i" 进入编辑模式，将pick修改成edit，按 "esc" 退出编辑模式。再在cmd中输入 ":wq"
4. git commit --amend 修改本地提交信息，同理按 "i" 进入编辑模式，编辑完毕按 "esc"，cmd输入 ":wq"
5. git rebase --continue
6. git push origin branch -f 强制提交修改远程提交记录

## 合并多次commit为一个commit
1. git log 找到要合并的commit记录，复制要合并的下一条与合并无关的版本号
2. git rebase -i 版本号
3. 按 "i" 进入编辑模式，将pick修改成s，按 "esc" 退出编辑模式。再在cmd中输入 ":wq"
4. git rebase --continue 将要被合并的commit信息删除，按 "esc" 退出编辑模式。再在cmd中输入 ":wq"
5. git push origin branch -f 强制提交修改远程提交记录