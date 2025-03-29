import React, {useState} from "react";
function App() {
    const [guess, setGuess] = useState('');
    const [result, setResult] = useState('');

    const handleSubmit = async() => {
        const url = `http://localhost:8080/game/guess?num=${guess}`;
        const response = await fetch(url); // 傳送請求
        const result = await response.text(); // 取得回應
        setResult(result);
    }

    return (
        <div>
            <h1>多人猜數字遊戲</h1>
            <input type="number" maxLength="4" 
                value={guess} onChange={(e) => setGuess(e.target.value)} />
            <button onClick={handleSubmit}>提交測試</button>    
            <h2>遊戲結果</h2>
            <h2>
                <pre>
                    {result}
                </pre>
            </h2>
        </div>
    )
}

export default App;