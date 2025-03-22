// css 引入 
import './App.css'

function App() {
    const text = 'Hello React + Springboot'
    const imgSrc = 'https://pic.pimg.tw/imksw/1661562296-228137591-g_n.jpg'
    return (
        <>
            <h1 style={{backgroundColor: 'red'}}>{text}</h1>
            <h1>{text} {text}</h1>
            <h1>{text.toUpperCase()}</h1>
            <input type="text" value={text} />
            <p />
            <img src={imgSrc}></img>
        </>
    )

}

export default App
