public class Calculadora {

    int sumar(String numero) throws CalculadoraException{

        if (numero==null)
            throw new CalculadoraException();

        String delimitador = ",";
        if(numero.startsWith("//")){
            delimitador=""+numero.charAt(2);

            if(delimitador.equals(""))
                throw new CalculadoraException();

            try{
                Integer.parseInt(delimitador);
                throw new CalculadoraException();
            } catch (NumberFormatException e ){

            }

            numero=numero.substring(numero.indexOf('\n')+1,numero.length());
            if(numero.contains("\n"))
                throw new CalculadoraException();
        } else {
            numero=numero.replaceAll("\\n",delimitador);
        }
        numero=numero.replaceAll("\\s",""); //Delete spaces
        numero=numero.replaceAll(delimitador,"\t"+delimitador+"\t");

        if(numero.equals(""))
            return 0;

        String[] nums = numero.split("\\t");

        try {
        int suma = Integer.parseInt(nums[0]);
            for (int i = 1; i < nums.length; i+=2) {
                if(nums[i].equals(delimitador)){
                    suma+= Integer.parseInt(nums[i+1]);
                }
            }

            return suma;

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
            throw new CalculadoraException();
        }
    }
}
