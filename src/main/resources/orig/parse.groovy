package orig

InputStream inputFile = getClass().classLoader.getResourceAsStream("ICD-9_PL_w_5_19.csv")
String[] lines = inputFile.text.split('\n')
List<String[]> rows = lines.collect {it.split('=')}

rows.each() { 
	descriptions = []
	codes = []
	it.eachWithIndex() { cell, i ->  
		i % 2 == 0 ? codes.add(cell) : descriptions.add(cell)	
	}	
	joined = descriptions.join(' -> ')
	code = codes.last()
	println "${code}, ${joined}"
}
