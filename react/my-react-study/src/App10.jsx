// BMI 計算
import React, {useState} from "react"

function App() {
    // 建立身高,體重與BMI的狀態
    const [height, setHeight] = useState(170)
    const [weight, setWeight] = useState(60)
    const [bmi, setBmi] = useState(0)
    // 計算 bmi
    function calcBmi() {
        const h = parseFloat(height) / 100
        const w = parseFloat(weight)
        const result = w / (h*h)
        setBmi(result.toFixed(2)) // 計算結果到小數點第二位
    }
    return(
        <div>
            身高: <input type="number" value={height} onChange={(e) => setHeight(e.target.value)} /><p />
            體重: <input type="number" value={weight} onChange={(e) => setWeight(e.target.value)} /><p />
            <button onClick={calcBmi}>計算 BMI</button><p />
            BMI: {bmi}
        </div>
    )

}

export default App
