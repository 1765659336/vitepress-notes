## 使用React-Hooks的注意事项
1. 不要在循环，条件或嵌套函数中调用 Hook。
遵守这条规则，你就能确保 Hook 在每一次渲染中都按照同样的顺序被调用。这让 React 能够在多次的 useState 和 useEffect 调用之间保持 hook 状态的正确。

我们可以在单个组件中使用多个hooks函数，如useState和useEffect,那么React 怎么知道哪个 state 对应哪个 useState。答案是 React 靠的是 Hook 调用的顺序。
:::details 点我查看示例代码
```js

function Form() {
  // 1. Use the name state variable
  const [name, setName] = useState('Mary');

  // 2. Use an effect for persisting the form
  useEffect(function persistForm() {
    localStorage.setItem('formData', name);
  });

  // 3. Use the surname state variable
  const [surname, setSurname] = useState('Poppins');

  // 4. Use an effect for updating the title
  useEffect(function updateTitle() {
    document.title = name + ' ' + surname;
  });

  // ...
}
```
:::

:::details 点我查看React解析Hooks顺序
```js
// ------------
// 首次渲染
// ------------
useState('Mary')           // 1. 使用 'Mary' 初始化变量名为 name 的 state
useEffect(persistForm)     // 2. 添加 effect 以保存 form 操作
useState('Poppins')        // 3. 使用 'Poppins' 初始化变量名为 surname 的 state
useEffect(updateTitle)     // 4. 添加 effect 以更新标题

// -------------
// 二次渲染
// -------------
useState('Mary')           // 1. 读取变量名为 name 的 state（参数被忽略）
useEffect(persistForm)     // 2. 替换保存 form 的 effect
useState('Poppins')        // 3. 读取变量名为 surname 的 state（参数被忽略）
useEffect(updateTitle)     // 4. 替换更新标题的 effect
// ...
```
:::

只要 Hook 的调用顺序在多次渲染之间保持一致，React 就能正确地将内部 state 和对应的 Hook 进行关联。但如果我们将一个 Hook (例如 persistForm effect) 调用放到一个条件语句中会发生什么呢？

:::details 点我查看代码
```js
// 🔴 在条件语句中使用 Hook 违反第一条规则
  if (name !== '') {
    useEffect(function persistForm() {
      localStorage.setItem('formData', name);
    });
  }
```
:::

在第一次渲染中 name !== '' 这个条件值为 true，所以我们会执行这个 Hook。但是下一次渲染时我们可能清空了表单，表达式值变为 false。此时的渲染会跳过该 Hook，Hook 的调用顺序发生了改变：

:::details 点我查看代码
```js
useState('Mary')           // 1. 读取变量名为 name 的 state（参数被忽略）
// useEffect(persistForm)  // 🔴 此 Hook 被忽略！
useState('Poppins')        // 🔴 2 （之前为 3）。读取变量名为 surname 的 state 失败
useEffect(updateTitle)     // 🔴 3 （之前为 4）。替换更新标题的 effect 失败
```
:::

React 不知道第二个 useState 的 Hook 应该返回什么。React 会以为在该组件中第二个 Hook 的调用像上次的渲染一样，对应的是 persistForm 的 effect，但并非如此。从这里开始，后面的 Hook 调用都被提前执行，导致 bug 的产生。
这就是为什么 Hook 需要在我们组件的最顶层调用。如果我们想要有条件地执行一个 effect，可以将判断放到 Hook 的内部：

:::details 点我查看代码
```js
useEffect(function persistForm() {
    // 👍 将条件判断放置在 effect 中
    if (name !== '') {
        localStorage.setItem('formData', name);
    }
});
```
:::

2. 只在 React 函数中调用 Hook
不要在普通的 JavaScript 函数中调用 Hook，可以在自定义 Hook 中调用其他 Hook

:::details 点我查看代码
```js
import { useState } from "react";

const ordinary = () => {
  const [state, setState] = useState();
  setState(1);
  console.log(state);
}

// 将其当成一个普通函数调用，报错
// React Hook "useState" is called in function "ordinary" that is neither a React function component nor a custom React Hook function. React component names must start with an uppercase letter. React Hook names must start with the word "use"  react-hooks/rules-of-hooks
ordinary();

const App = () => {
  const [state, setState] = useState(0);
  return (
    <div>{state}</div>
  )
}

export default App;
```
:::

## ESLint 插件
react官方提供了一个eslint插件，为我们检测是否符合上述两条规则
```npm install eslint-plugin-react-hooks --save-dev```

:::details 点我查看Eslint配置
```json
{
  "plugins": [
    // ...
    "react-hooks"
  ],
  "rules": {
    // ...
    "react-hooks/rules-of-hooks": "error", // 检查 Hook 的规则
    "react-hooks/exhaustive-deps": "warn" // 检查 effect 的依赖
  }
}
```
:::