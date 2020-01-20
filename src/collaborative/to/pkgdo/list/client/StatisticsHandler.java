/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborative.to.pkgdo.list.client;

import Entities.ItemEntity;
import Entities.TaskEntity;
import Entities.ToDoEntity;
import Entities.UserEntity;
import Utils.CurrentUser;
import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import Utils.Types;
import static Utils.Types.TASK_STATUS_DONE;
import static Utils.Types.TASK_STATUS_INPROGRESS;
/**
 *
 * @author OMNIA
 */
public class StatisticsHandler {
   List<ToDoEntity> lists=new ArrayList<>();
   List<ItemEntity> items=new ArrayList<>();
   List<TaskEntity> tasks=new ArrayList<>();
   List<TodoStatstics> listStatistics=new ArrayList<>();
  
   UserEntity userentity;   
    
   public StatisticsHandler(UserEntity user)
   {
    userentity= user;
    setLists(); 
   
   }
   private void setLists()
   {
   
    lists= userentity.getTodoList();
    
   } 
    
   
   private void setItems(ToDoEntity todo)
   {
     items=todo.getItemsList() ;
   } 
    
   
   private void setTasks(ItemEntity item)
   {
     tasks=item.getTasksList();
   } 
    
   
   private int getFinishedTasksItem(ItemEntity item)
   { 
       setTasks(item);
       int counter=0;
       
       for(TaskEntity task:tasks)
       {
         if(task.getStatus()==TASK_STATUS_DONE)
          counter++;
       }
       ;
       return counter;
   }
     private int getPendingTasksItem(ItemEntity item)
   { 
       setTasks(item);
       int counter=0;
       
       for(TaskEntity task:tasks)
       {
         if(task.getStatus()==TASK_STATUS_INPROGRESS)
          counter++;
       }
       ;
       return counter;
   } 
  private int getFinishedTasks(ToDoEntity list)
   { 
       setItems(list);
       
       int counter=0,percentage=0;
       for(ItemEntity item:items)
       {  setTasks(item);
         for(TaskEntity task:tasks)
         {
            if(task.getStatus()==TASK_STATUS_DONE)
            counter++;
         }
         if(tasks.size()>0)
         percentage=(counter/tasks.size())*100;
         
      }  
       return percentage;
   }

 
   public List<MItemState> setItemStates(ToDoEntity todo)
   { 
       System.out.println("todo's item list size "+todo.getItemsList().size());
       List<MItemState> itemstates=new ArrayList<>();
       //setItems(todo);
       for(ItemEntity item:todo.getItemsList())
       {
         System.out.println("item title "+item.getTitle()+"finishedtasks : "+getFinishedTasksItem(item)+
                 "ending tasks"+getPendingTasksItem(item)); 
           
         MItemState stat=new MItemState(item.getTitle(),getFinishedTasksItem(item),getPendingTasksItem(item));
         
         itemstates.add(stat);
       }
     
       return itemstates;
   } 
   

   
   public List<TodoStatstics> setListsStatistics()
   { 
       List<TodoStatstics> graphs=new ArrayList<>();
       for(ToDoEntity list:lists )
       {
        TodoStatstics stat=new TodoStatstics(list,getFinishedTasks(list));
        graphs.add(stat);
       }
     
       return graphs;
   } 
   


 }

