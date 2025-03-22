function SendMailForm() {
    return (
        <>
            <h2>Send Mail Form</h2>
            <form action="http://localhost:8080/sendmail" method="POST">
                收件人:
                <input type="email" name="to" required /><p />
                信件主題:
                <input type="text" name="header" required /><p />
                信件內容:
                <textarea name="content"></textarea><p />
                <button type="submit">Send Mail</button>
            </form>
        </>
    )
}
export default SendMailForm;
