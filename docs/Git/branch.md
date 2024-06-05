## 命名分支必须遵守一些简单的规则。
1、可以使用斜杠（/)创建一个分层的命名方法。但是，该分支名不能以斜线结尾。
2、分支名不能以减号（-）开头。
3、以斜杠分割的组件不能以点（.)开头。如feature/.new这样的分支名是无效的。
4、分支名的任何地方都不能包含两个连续的点（..)
5、此外，分支名不能包含以下内容：
---任何空格活其他空白字符：
---在Git中具有特殊含义的字符，包括波浪线（~）、插入符（^)、冒号（:)、
问号（？）、星号（*）、左方括号（[)。
     ——ASCII码控制字符，即值小于八进制\040的字符，或DEL字符（八进制\177)。
<span class="span-info-message">后端从正式环境分支拉了一个紧急分支为#934,修复一个紧急bug,当我修复完毕之后，在当前版本分支上拉取#934分支代码一直报下面这个错，说我没有指明分支名，因此分支的命名还是要遵循一些命名规则</span>
```
You asked to pull from the remote 'origin', but did not specify
a branch. Because this is not the default configured remote
for your current branch, you must specify a branch on the command line.
```
最后我是在gitlab中从源分支#934新建一个934分支，然后从934拉取了代码