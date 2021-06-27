package entidade;

import entidade.Vacinacao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-26T21:26:57")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> sus;
    public static volatile SingularAttribute<Paciente, Date> nascimento;
    public static volatile SingularAttribute<Paciente, String> telefone;
    public static volatile ListAttribute<Paciente, Vacinacao> vacinaList;
    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, Integer> id;

}