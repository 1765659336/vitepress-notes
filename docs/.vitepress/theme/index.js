import DefaultTheme from 'vitepress/theme';
// 引入动画库
import 'animate.css';
// 想引入全局自己的 css 文件，也可以在这里引入
import "./style/theme.css";
import "./style/index.css";

export default {
    ...DefaultTheme,
    enhanceApp({ app }) {
    },
}

