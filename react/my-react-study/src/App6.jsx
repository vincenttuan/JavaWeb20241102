// 陣列 map, filter 的使用

function App() {
    // 陣列
    const fruits = [
        {id:1, name:'Apple', price:20},
        {id:2, name:'Banana', price:30},
        {id:3, name:'Orange', price:40}
    ]

    // 陣列過濾
    const filterFruits = fruits.filter((fruit) => {
        return fruit.price > 25;
    })

    return (
        <>
            <h2>顯示所有水果</h2>
            <ul>
                {fruits.map((fruit, index) => (
                    <li key={index}>{fruit.name} ${fruit.price}</li>
                ))}
            </ul>
            <hr />
            <h2>顯示價格 &gt; 25元的水果</h2>
            <ul>
                {filterFruits.map((fruit, index) => (
                    <li key={index}>{fruit.name} ${fruit.price}</li>
                ))}
            </ul>    
        </>
    )
}

export default App
