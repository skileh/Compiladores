class Parser{

	AnaliseLexica scanner;
	

	Parser(AnaliseLexica s)
	{
		scanner = s;
	}

	ArvoreSintatica parseProg() throws Exception
	{

		ArvoreSintatica resultado = Exp();
		Token tokenCorrente = scanner.getNextToken();
		if(tokenCorrente.token != TokenType.EOF)
					throw (new Exception("Estava esperando: EOF"));

		return resultado;
	 
	}

	Exp Exp() throws Exception
	{       Exp exp1, exp2;
		Token tokenCorrente =  scanner.getNextToken();
		if(tokenCorrente.token == TokenType.NUM){
			return new Num(Integer.parseInt(tokenCorrente.lexema+""));
		}		
		
		if(tokenCorrente.token == TokenType.APar)
			{
				
				// abre a primeira expressão
				exp1 = Exp();
				int operacao=0;
				// roda encontrando os numeros e a cada iteração multiplica por 10
				// para quando encontra um operador
				while(operacao == 0){ // não é operação
					tokenCorrente = scanner.getNextToken();
					if(tokenCorrente.token == TokenType.NUM){
						exp1.num = exp1.num*10 + Integer.parseInt(tokenCorrente.lexema+"");
					}
					else{ // significa que é uma operação
						operacao=1;
					}
				}
						        		
				if(exp1 == null)
					throw (new Exception("Não encontrei expressão!"));
				
				Operador op = Op (tokenCorrente);

				if (op == null)
					throw (new Exception("Não encontrei operador!"));

				exp2 = Exp();
				operacao=0;
				//faz o mesmo que o while acima e só para quando encontra um fecha parentes ou outra coisa
				while(operacao == 0){ // não é operação, logo é um numero.. esperamos
					tokenCorrente = scanner.getNextToken();
					if(tokenCorrente.token == TokenType.NUM){
						exp2.num = exp2.num*10 + Integer.parseInt(tokenCorrente.lexema+"");
					}
					else{ //Tem que ser um fecha parentes
						operacao=1;
					}
				}
				op.arg1 = exp1;
				op.arg2 = exp2;

				if(tokenCorrente.token != TokenType.FPar)
					throw (new Exception("Estava esperando:)"));
				return op;
								
			} else throw (new Exception ("Estava esperando: ( ou <NUM>"));

		//return null;
		
	}

	Operador Op (Token tokenCorrente) throws Exception
		{
		
		switch(tokenCorrente.token){
			case SOMA:
				return new Soma(null,null);
			case MULT:
				return new Mult(null,null);
			case SUB:
				return new Sub(null,null);
			case DIV:
				return new Div(null,null);
			default: 
		}
		return null;
			

		}

}
