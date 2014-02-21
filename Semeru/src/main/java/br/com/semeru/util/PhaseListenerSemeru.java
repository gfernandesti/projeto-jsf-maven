/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.semeru.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author gabriel
 */
public class PhaseListenerSemeru implements PhaseListener{
    //Antes da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("antes da fase: "+getPhaseId());
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
            
        }
        
    }
    //Depois da fase
    @Override
    public void beforePhase(PhaseEvent fase) {
         System.out.println("Depois da fase: "+getPhaseId());
         
        if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            Session session = FacesContextUtil.getRequestSession();
            try {
              session.getTransaction().commit();
            } catch (Exception e) {
                if(session.getTransaction().isActive()){
                    session.getTransaction().rollback();
                }
            }
            finally{
                session.close();
            }
        }
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}

    