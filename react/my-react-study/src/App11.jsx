import React, { useState } from "react";

function App() {
    const [guess, setGuess] = useState(''); // 玩家猜測的數字 
    const [results, setResults] = useState([]); // 累積結果陣列

    // 處理玩家猜測
    const handleGuess = () => {
        const gus = guess.split('').map(Number); // "1234" -> [1, 2, 3, 4]
        const [acount, bcount] = checkAns(gus); // 得到 AB
        const newResult = `${guess} => ${acount}A ${bcount}B`; // 此次結果
        // 將 newResult, 放在 results 後面
        //setResults([...results, newResult]); // ...results 表示之前的資訊, newResult 放在"後"面
        setResults([newResult, ...results]); // ...results 表示之前的資訊, newResult 放在"前"面
    }

    // 比對 A B 資料
    const checkAns = (gus) => {
        const ans = [1, 2, 3, 4]; // 假設答案是 1234
        let acount = 0;
        let bcount = 0;

        // 判斷 A : 數字正確且位置正確
        for(let i=0;i<4;i++) {
            if(ans[i] === gus[i]) {
                acount++;
                continue;
            }
        }
        // 判斷 B : 數字正確且位置不正確
        for(let i=0;i<4;i++) {
            for(let k=0;k<4;k++) {
                if(ans[i] === gus[k]) {
                    bcount++;
                    continue;
                }
            }
        }
        bcount = bcount - acount; // 減去重複計算的部分
        return [acount, bcount];
    }

    return (
        <div>
            <h1>猜數字遊戲</h1>
            <div>
                <input type="number" value={guess} onChange={(e) => setGuess(e.target.value)} maxLength="4" placeholder="請輸入四位數字(1~9)" />
                <button onClick={handleGuess}>提交猜測</button>
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