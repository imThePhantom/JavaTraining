<html>
<body>
	<h2>Hello World!</h2>
	<form method="POST">
		<p>Who are you?</p>
		<br> <label>Name: </label> <input type="text" name="name" />
		<div>
            <input type="radio" name="isMarried" value="null" checked hidden="true"/>
			<input type="radio" name="isMarried" value="mrs"/> Mrs
			<input type="radio" name="isMarried" value="ms"/> Ms
		</div>
		<div>
            <input type="checkbox" name="maths" checked="checked" /> Maths
            <input type="checkbox" name="physics"  /> Physics
            <input type="checkbox" name="chemistry" checked="checked" /> Chemistry
        </div>
		<button formaction="hello">Hello Spring!</button>
        <button formaction="readall">Read All Parameters</button>
	</form>
	
	<h2><a href="/HelloSpringMVC/clock">Show o'clock</a></h2>
</body>
</html>