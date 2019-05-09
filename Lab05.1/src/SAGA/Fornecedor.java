package SAGA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Representacao do fornecedor.
 * @author Lourival Gonçalves Prata Netto - 119111236 - UFCG.
 *
 */
public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<String, Produto> produtos;

    /**
	 * Construtoi um novo fornecedor apatir do seu nome, email e telefone, e inicializa um HashMap de produtos desse fornecedor.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 */
    public Fornecedor(String nome, String email, String telefone)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

    /**
	 * Cadastra um novo produto no fornecedor com base no seu nome, descricao e preco, e adiciona ao HashMap de produtos onde a chave é uma string composta pelo nome + descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
     * @param preco preco do produto.
	 * @return um booleano caso o produto seja adicionado com sucesso.
	 */
    public boolean cadastraProduto(String nome, String descricao, double preco)
    {
        String chave = nome + descricao;
        if (this.produtos.containsKey(chave))
        {
            return false;
        }
        Produto produto = new Produto(nome, descricao, preco);
        this.produtos.put(chave,produto);
        return true;
    }
    /**
	 * Exibe um produto apatir do seu nome e descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return "Produto não cadastrado.";
        }
        return this.produtos.get(chave).toString();
    }

    /**
	 * Exibe todos os produtos já cadastrados de um determinado fornecedor.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO | PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProdutos()
    {
        String msg = "";
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        } else
        {
            for (Produto produto: produtos.values())
            {
                msg += produto.toString() + " | ";
            }
        }
        return msg.substring(0,msg.length()-3);
    }

    /**
	 * Exibe todos os produtos já cadastrados de todos os fornecedores.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO | PRODUTO - DESCRICAO - PRECO.
	 */
    public String exibeTodosProdutosFornecedores()
    {
        String msg = "";
        if (produtos.isEmpty())
        {
            return "Sem produtos cadastrados.";
        } else
        {
            for (Produto produto: produtos.values())
            {
                msg += this.nome + produto.toString() + " | ";
            }
        }
        return msg;
    }

    /**
	 * Edita o preco de um produto apartir do seu nome, descricao e do seu novo preco.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @param valor novo valor do produto.
	 * @return retorna um booleano True caso a edicao seja um sucesso.
	 */
    public boolean editaPrecoProduto(String nome, String descricao, double preco)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return false;
        }
        this.produtos.get(chave).setPreco(preco);
        return true;
    }

    /**
	 * Remove um produto do fornecedor apartir do nome do produto e sua descricao.
	 * @param nome nome do produto.
     * @param descricao descricao do produto.
	 * @return retorna um booleano True caso o produto seja removido com sucesso.
	 */
    public boolean removeProduto(String nome, String descricao)
    {
        String chave = nome + descricao;
        if (!this.produtos.containsKey(chave))
        {
            return false;
        }
        this.produtos.remove(chave);
        return true;
    }

    /**
	 * Seta um email para o fornecedor.
	 * @param email novo email.
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
	 * Seta um telefone para o fornecedor.
	 * @param telefone novo telefone.
	 */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }

}
