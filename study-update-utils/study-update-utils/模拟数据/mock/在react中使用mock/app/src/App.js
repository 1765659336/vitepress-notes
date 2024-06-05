import logo from "./logo.svg";
import "./App.css";
import { test } from "./api";
import { openMock } from "./utils/env";
if (openMock) {
  // 使用mock就引入，不使用就注释掉
  require("./mock/test");
}

function App() {
  test()
    .then((res) => {
      console.log(res);
    })
    .catch((err) => {
      console.log(err);
    });

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
