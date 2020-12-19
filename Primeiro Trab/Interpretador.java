class Interpretador{

    public int valores (ArvoreSintatica arv){
   
        if (arv instanceof Mult){
            return (valores(((Mult) arv).arg1) *  valores(((Mult) arv).arg2));
        }
        if (arv instanceof Soma){
            return (valores(((Soma) arv).arg1) + valores(((Soma) arv).arg2));
        }
        if (arv instanceof Sub){
            return (valores(((Sub) arv).arg1) - valores(((Sub) arv).arg2));
        }
        if (arv instanceof Div){
            return (valores(((Div) arv).arg1) / valores(((Div) arv).arg2));
        }
	    if (arv instanceof Num){
            return (((Num) arv).num);
        }
        
	   return 0;
        
    }
}