import React, { useState } from "react";

function App() {
    const [guess, setGuess] = useState(''); // 玩家猜測的數字 
    const [results, setResults] = useState([]); // 累積結果陣列

    return (
        <div>
            <h1>猜數字遊戲</h1>
            <div>
                <input type="number" value={guess} onChange={(e) => setGuess(e.target.value)} maxLength="4" placeholder="請輸入四位數字(1~9)" />
                <button>提交猜測</button>
            </div>
            <h3>結果</h3>
            <ul>
                {
                    results.map((result, index) => (
                        <li key={index}>{result}</li>
                    ))
                }
            </ul>
        </div>
    )
}

export default App;