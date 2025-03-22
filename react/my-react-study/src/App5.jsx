// 陣列

function App() {
    // 建立陣列
    const fruits = ['Apple', 'Orange', 'Banana', 'Watermelon']

    // 利用 <li> 標籤將陣列內容條列出來
    // key 是幫助 React 來識別每一個元素得唯一性
    const listFruits = [
        <li key="1">Apple</li>,
        <li key="2">Orange</li>,
        <li key="3">Banana</li>,
        <li key="4">Watermelon</li>
    ]
    return (
        <>
            {fruits}
            <hr />
            <ul>
                {listFruits}
            </ul>
            <hr />
            <ul>
                {fruits.map((fruit, index) => (
                    <li key={index}>{fruit}</li>
                ))}
            </ul>
        </>
    )    
}

export default App
