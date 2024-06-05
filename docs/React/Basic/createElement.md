## React.createElement()

React并没有强制使用者一定使用jsx，完全可以用全javascript代码来做任何事情。
所有的jsx都是去调用了React.createElement()。

:::details 点我查看代码
```js
// JSX
class Hello extends React.Component {
  render() {
    return <div>Hello {this.props.toWhat}</div>;
  }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Hello toWhat="World" />);

// -------------------React.createElement

class Hello extends React.Component {
  render() {
    return React.createElement('div', null, `Hello ${this.props.toWhat}`);
  }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(React.createElement(Hello, {toWhat: 'World'}, null));

```
:::