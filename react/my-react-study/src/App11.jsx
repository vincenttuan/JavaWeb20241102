function App() {
    return (
        <div>
            <h1>猜數字遊戲</h1>
            <div>
                <input type="number" maxLength="4" placeholder="請輸入四位數字(1~9)" />
                <button>提交猜測</button>
            </div>
            <h3>結果</h3>
            <ul>
                
            </ul>
        </div>
    )
}

export default App;