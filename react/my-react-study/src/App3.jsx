// css 引入 
import './App.css'

function App() {
    const text = 'Hello React + Springboot'

    return (
        <>
            <h1>{text}</h1>
            <h1>{text} {text}</h1>
            <h1>{text.toUpperCase()}</h1>
            <input type="text" value={text} />
        </>
    )

}

export default App
