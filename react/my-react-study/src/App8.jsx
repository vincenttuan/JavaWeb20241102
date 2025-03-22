// 狀態 
import React, {useState} from "react"

function App() {
    // 創建一個名為 count 的狀態, 初始值為 0
    // 透過 setCount 來改變 count 內容值
    const [count, setCount] = useState(0);

    return(
        <div>
            <h1>目前數值: {count}</h1>
            <button onClick={() => setCount(count + 1)}>增加 1</button>
            <button onClick={() => setCount(count - 1)}>減少 1</button>
        </div>
    )

}

export default App
