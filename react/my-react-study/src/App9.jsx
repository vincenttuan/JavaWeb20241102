// 輸入框狀態
import React, {useState} from "react";

function App() {
    //const [name, setName] = React.useState('')
    const [name, setName] = useState('')

    return (
        <div>
            名字: <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
            <p />
            所輸入的名字是: {name}
            <p />
        </div>
    )

}

export default App
