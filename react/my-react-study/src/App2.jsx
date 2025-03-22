// 子組件(組件名必需要大寫開頭)
function Bar() {
    return(
        <h2>我是子組件 Bar</h2>
    )
}

// 子組件(組件名必需要大寫開頭)
function Sub() {
    return(
        <h2>我是子組件 Sub</h2>
    )
}

// 父組件(組件名必需要大寫開頭)
function App() {
    return(
        <>
            <h1>我是父組件</h1>
            <Sub />
            <Bar />
        </>
    )
}

export default App
