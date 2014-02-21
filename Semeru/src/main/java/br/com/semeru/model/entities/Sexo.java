

package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "sexo")
public class Sexo implements Serializable{
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue
    @Column(name = "idSexo", nullable = false)
    private Integer idsexo;
    @Column(name = "Descricao",unique = true,nullable = false,length = 9)
    private String descricao;
    
    @OneToMany(mappedBy ="sexo", fetch = FetchType.LAZY)
    @ForeignKey(name ="PessoaSexo")
    private List<Pessoa> pessoas;
    public Sexo() {
    }

    public Integer getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idsexo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (!Objects.equals(this.idsexo, other.idsexo)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
