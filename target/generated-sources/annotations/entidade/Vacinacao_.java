package entidade;

import entidade.Enfermeiro;
import entidade.Paciente;
import entidade.Vacina;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-26T21:26:57")
@StaticMetamodel(Vacinacao.class)
public class Vacinacao_ { 

    public static volatile SingularAttribute<Vacinacao, Enfermeiro> enfermeiro;
    public static volatile SingularAttribute<Vacinacao, Vacina> vacina;
    public static volatile SingularAttribute<Vacinacao, String> lote;
    public static volatile SingularAttribute<Vacinacao, Paciente> paciente;
    public static volatile SingularAttribute<Vacinacao, Date> dataVacina;
    public static volatile SingularAttribute<Vacinacao, Integer> id;

}