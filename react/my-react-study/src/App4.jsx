// 事件處理

function App() {

    const handleClick1 = function() {
        alert('OK1');
    };

    const handleClick2 = () => {
        alert('OK2');
    };

    const handleClick3 = (e) => {
        // e: 事件資訊
        alert('OK3 ' + e);
        console.log(e);
    };

    return(
        <>
            <button onClick={function(){alert('OK');}}>我是按鈕</button><p />
            <button onClick={handleClick1}>我是按鈕 1</button><p />
            <button onClick={handleClick2}>我是按鈕 2</button><p />
            <button onClick={handleClick3}>我是按鈕 3</button><p />
        </>
    )

}

export default App

