import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
// SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa")
import java.util.concurrent.ConcurrentHashMap;

class Filmes {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;
    private String tituloOriginal;
    private Date dataLancamento;
    private int duracao;
    private String genero;
    private String idiomaOriginal;
    private String situacao;
    private String orcamento;
    private String[] palavrasChave;

    public Filmes() {
        this.nome = "";
        this.tituloOriginal = "";
        this.dataLancamento = new Date();
        this.duracao = 0;
        this.genero = "";
        this.idiomaOriginal = "";
        this.situacao = "";
        this.orcamento = "0.0";
        this.palavrasChave = new String[20];
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getOrcamento() {
        return orcamento;
    }
    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }
    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public Date getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public String getTituloOriginal() {
        return tituloOriginal;
    }
    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
    public String[] getPalavrasChave() {
        return palavrasChave;
    }
    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String imprimir() {
        String palavrasChave = criarStringPalavrasChave();

        return getNome() + " " +
               getTituloOriginal() + " " +
               sdf.format(getDataLancamento()) + " " +
               getDuracao() + " " +
               getGenero() + " " +
               getIdiomaOriginal() + " " +
               getSituacao() + " " +
               getOrcamento() + " " +
               palavrasChave;
    }

    public String criarStringPalavrasChave() {
        String palavrasChave = "";
        palavrasChave += "[";
        for(int i = 0; i < getPalavrasChave().length; i++) {
            if(getPalavrasChave()[i] != null) {
                palavrasChave += getPalavrasChave()[i];
                palavrasChave += ", ";
            } 
        }
        palavrasChave += "]";
        if(!palavrasChave.equals("[]")) {
            palavrasChave = palavrasChave.replace(", ]", "");
            palavrasChave += "]";
        }

        return palavrasChave;
    }

    public String[] criarVetorInfoFilme() {
        String palavrasChave = criarStringPalavrasChave();
        String strDuracao = Integer.toString(getDuracao());
        String[] arr = {getNome(), getTituloOriginal(), sdf.format(getDataLancamento()), strDuracao, getIdiomaOriginal(), getSituacao(), getOrcamento(), criarStringPalavrasChave()};
        return arr;
    }

    public Filmes clonar() {
        Filmes clonado = new Filmes();
        clonado.setNome(this.nome);
        clonado.setTituloOriginal(this.tituloOriginal);
        clonado.setDataLancamento(this.dataLancamento);
        clonado.setDuracao(this.duracao);
        clonado.setGenero(this.genero);
        clonado.setIdiomaOriginal(this.idiomaOriginal);
        clonado.setSituacao(this.situacao);
        clonado.setOrcamento(this.orcamento);
        clonado.setPalavrasChave(this.palavrasChave);

        return clonado;
    }

    public void ler(String nomArq) throws Exception {
        String caminho = "./tmp/filmes/";
        FileReader fr = new FileReader(caminho + nomArq);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        String[] arrayPalavrasChave = new String[20];
        
        while(!linha.contains("<title>")) linha = br.readLine();
        setNome(parseNome(removeTags(linha).trim()));

        while(!linha.contains("<span class=\"release\">")) linha = br.readLine();
        linha = br.readLine();
        setDataLancamento(sdf.parse(parseNome(linha).trim()));

        while(!linha.contains("<span class=\"genres\">")) linha = br.readLine();
        linha = br.readLine();
        linha = br.readLine();
        setGenero(parseGenero(removeTags(linha)).trim());

        while(!linha.contains("<span class=\"runtime\">")) linha = br.readLine();
        linha = br.readLine();
        linha = br.readLine();
        setDuracao(parseDuracao(linha));

        while(!linha.contains("<p class=\"wrap\"><strong>")) linha = br.readLine();
        setTituloOriginal(parseTituloOriginal(removeTags(linha).trim()));

        while(!linha.contains("Situação")) linha = br.readLine();
        setSituacao(parseSituacao(removeTags(linha)));

        while(!linha.contains("Idioma original")) linha = br.readLine();
        setIdiomaOriginal(parseIdiomaOriginal(removeTags(linha).trim()));

        while(!linha.contains("Orçamento")) linha = br.readLine();
        setOrcamento(parseOrcamento(removeTags(linha).trim()));

        while(!linha.contains("Palavras-chave")) linha = br.readLine();
        linha = br.readLine();
        linha = br.readLine();
        
        String temp = "";
        int cont = 0;
        if(temChaves(linha)) {
            while(!linha.contains("</ul>")) {
                if(linha.contains("<li>")) {
                    temp = removeTags(linha).trim();
                    arrayPalavrasChave[cont] = temp;
                    cont++;
                }
                linha = br.readLine();
            }
            setPalavrasChave(arrayPalavrasChave);
        }

        //setPalavrasChave(parseOrcamento(removeTags()))
        //setOrcamento(parseOrcamento(removeTags(linha).trim()));

        br.close();
    }

    private boolean temChaves(String entrada) {
        boolean resultado = false;
        String entradaTratada = entrada.trim();
        if(entradaTratada.contains("<ul>")) resultado = true;
        return resultado;
    }

    private String removeTags(String original) {
        String limpa = "";
        for(int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == '<') {
                while(original.charAt(i) != '>') i++;
            } else {
                limpa += original.charAt(i);
            }
        }

        return limpa;
    }
    
    private String parseSituacao(String original) {
        String linha = original.substring(13, original.length());
        return linha;
    }
    private String parseOrcamento(String original) {
        return original.substring(11, original.length());
    }
    private String parseIdiomaOriginal(String original) {
        return original.substring(16, original.length());
    }
    private String parseTituloOriginal(String original) {
        return original.substring(16, original.length());
    }
    private String parseGenero(String original) {
        return original.replace("&nbsp;", "");
    }
    private String parseNome(String original) {
        String limpa = "";
        for(int i = 0; original.charAt(i) != '('; i++) limpa += original.charAt(i);
        return limpa.trim();
    }
    private int parseDuracao(String original) {
        int nMinutos = 0;
        nMinutos = calcularDuracao(original.trim());
        return nMinutos;
    }
    private int calcularDuracao(String txt) {
        String horasS = "";
        String minS = "";
        int horas = 0;
        int min = 0;

        for(int i = 0; txt.charAt(i) != 'h'; i++)
            horasS += txt.charAt(i);

        for(int i = 2; txt.charAt(i) != 'm'; i++)
            minS += txt.charAt(i);

        horas = Integer.parseInt(horasS.trim());
        min = Integer.parseInt(minS.trim());

        return horas*60 + min;
    }
}

class Busca{
    public static String buscaSequencial(Filmes[] array, String busca){
        for(int i=0;i<array.length;i++){
            if(array[i].getNome().equals(busca)){
                return "SIM";
            }
        }
        return "NAO";
    }
}

class TP0201 {
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];        
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while(isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        Filmes filmes[] = new Filmes[numEntrada];
        for (int i = 0; i < numEntrada; i++) {
            filmes[i] = new Filmes();
            try {
                filmes[i].ler(entrada[i]);
            } catch (Exception e) {

            }
        }

        /*String nomeFilme = MyIO.readLine();
        do {
            System.out.println(Busca.buscaSequencial(filmes, nomeFilme));
            nomeFilme = MyIO.readLine();
        } while(isFim(nomeFilme) == false);*/
        

        for(int i = 0; i < numEntrada; i++) {
            MyIO.println(filmes[i].getNome());
        }
    }

    private static boolean isFim(String entrada) {
        return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
    }
}