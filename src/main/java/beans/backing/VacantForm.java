package beans.backing;

import beans.helper.ColoniaHelper;
import beans.model.Candidate;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacantForm {
    
    @Inject
    private Candidate candidate;
    
    private boolean sendedComment;
    
    @Inject
    private ColoniaHelper coloniaHelper;
    
    Logger log = LogManager.getRootLogger();

    public VacantForm() {
        log.info("Creating the VacantForm object");
    }
    
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    
    public String send() {
        if (this.candidate.getName().equals("Juan")) {
            if (this.candidate.getLastname().equals("Perez")) {
                String msg = "Thanks, but Juan Perez still working with us.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entering to success case");
            return "success";
        } else {
            log.info("Entering to fail case");
            return "fail";
        }
    }
    
    public void postalCodeListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uIViewRoot = facesContext.getViewRoot();
        
        int newPostalCode = ((Long) valueChangeEvent.getNewValue()).intValue();
        UIInput coloniaIdInputText = (UIInput) uIViewRoot.findComponent("vacantForm:coloniaId");
        
        int coloniaId = this.coloniaHelper.getColoniaById(newPostalCode);
        coloniaIdInputText.setValue(coloniaId);
        coloniaIdInputText.setSubmittedValue(coloniaId);

        UIInput cityInputText = (UIInput) uIViewRoot.findComponent("vacantForm:city");
        String newCity = "Veracruz";
        cityInputText.setValue(newCity);
        cityInputText.setSubmittedValue(newCity);

        facesContext.renderResponse();
    }
    
    public void hideComment(ActionEvent actionEvent) {
        this.sendedComment = !this.sendedComment;
    }

    public boolean isSendedComment() {
        return sendedComment;
    }
    public void setSendedComment(boolean sendedComment) {
        this.sendedComment = sendedComment;
    }

    public ColoniaHelper getColoniaHelper() {
        return coloniaHelper;
    }
    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }
    
    
}
