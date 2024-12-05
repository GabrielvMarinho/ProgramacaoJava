package Main;

import CRUDs.CrudCliente;
import CRUDs.CrudPlano;
import CRUDs.CrudServicoAdicional;
import Classes.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
//        System.out.println(CrudPlano.cadastro(new Plano("TIM", "Plano ok", 100, 10, "Bem rapido", 99.9)));
//
//        System.out.println(CrudPlano.consultaIndividual(2));
//
//        for(Plano p: CrudPlano.consultaOperadora("TIM")){
//            System.out.println(p.toString());
//        }
//
//        CrudPlano.atualizacao(new Plano(0,"CLARO", "Plano bom", 100, 10, "Bem rapido", 99.9));
//
//        CrudPlano.remocao(1);
        //---------------------------------------------------------
//        CrudServicoAdicional.cadastro(new ServicoAdicional("muito legal e ruim", 10));
//
//        for(ServicoAdicional s:CrudServicoAdicional.consulta()){
//            System.out.println(s.toString());
//        }

//        CrudServicoAdicional.atualizacao(new ServicoAdicional(1, "muito bom", 2));
        //---------------------------------------------------------
//        CrudCliente.cadastro(new Cliente("gabriel", "gabriel@gmail.com", "998823273", CrudPlano.consultaIndividual(1)));

//        for(Cliente c:CrudCliente.consulta()){
//            System.out.println(c.toString());
//        };

//        CrudCliente.atualizacao(new Cliente(2, "bia", "bia@gmail.com", "998823273", CrudPlano.consultaIndividual(2)));

//        CrudCliente.remocao(2);
        //---------------------------------------------------------
//        CrudPlano.adicionarServico(CrudPlano.consultaIndividual(1), CrudServicoAdicional.consultaId(2));

//        CrudPlano.removerServico(CrudPlano.consultaIndividual(1), CrudServicoAdicional.consultaId(1));

//        for(ServicoAdicional p:CrudPlano.consultaServicosAdicionais(CrudPlano.consultaIndividual(1))){
//            System.out.println(p.toString());
//        }

//        for(Cliente c:CrudCliente.clientesEmUmPlano(CrudPlano.consultaIndividual(1))){
//            System.out.println(c.toString());
//        }
//        CrudPlano.associarContratoPlano(new Contrato(CrudPlano.consultaIndividual(1),"esses são os termos", "17-11-2006", "17-11-2094"));

        CrudPlano.buscarContratoPlano(CrudPlano.consultaIndividual(1)).toString();

    }
}