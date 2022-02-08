package com.sample.service;

import com.sample.entity.QuestionEntity;
import com.sample.entity.QuestionQuizEntity;
import com.sample.entity.QuizEntity;
import com.sample.model.Question;
import com.sample.model.Quiz;
import com.sample.repository.QuestionQuizRepository;
import com.sample.repository.QuestionRepository;
import com.sample.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionQuizRepository questionQuizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<Quiz> getAllQuiz(){ //getsQuiz
        List<Quiz> response = new ArrayList<Quiz>();

        List<QuizEntity> quizEntities=getQuizEntity();
        for(int i=0; i< quizEntities.size(); i++){
            Long quizId;
            String quizName;
            List<Question>questionList=new ArrayList<>();

            quizId=quizEntities.get(i).getId();
            quizName=quizEntities.get(i).getName();
            List<QuestionQuizEntity> questionQuizEntities=getQuestionQuizEntity(quizId).get();

            for(int j=0; j<questionQuizEntities.size(); j++){
                Long questionId;

                questionId=questionQuizEntities.get(j).getQuestionId();
                QuestionEntity questionEntity=getQuestionEntity(questionId).get();

                String question,answer_one,answer_two,answer_three;

                question=questionEntity.getQuestion();
                answer_one=questionEntity.getAnswer_one();
                answer_two=questionEntity.getAnswer_two();
                answer_three=questionEntity.getAnswer_three();

                Question question1=new Question(question,answer_one,answer_two,answer_three);
                questionList.add(question1);
            }

            Quiz quiz=new Quiz(quizName,questionList);
            response.add(quiz);
        }

        return response;
    }

    public Quiz getQuizById(Long id){
        Quiz response = new Quiz();
        QuizEntity quizEntity=quizRepository.getById(id);

        Long quizId;
        String quizName;
        List<Question>questionList=new ArrayList<>();

        quizId=quizEntity.getId();
        quizName=quizEntity.getName();
        List<QuestionQuizEntity> questionQuizEntities=getQuestionQuizEntity(quizId).get();

        for(int j=0; j<questionQuizEntities.size(); j++){
            Long questionId;

            questionId=questionQuizEntities.get(j).getQuestionId();
            QuestionEntity questionEntity=getQuestionEntity(questionId).get();

            String question,answer_one,answer_two,answer_three;

            question=questionEntity.getQuestion();
            answer_one=questionEntity.getAnswer_one();
            answer_two=questionEntity.getAnswer_two();
            answer_three=questionEntity.getAnswer_three();

            Question question1=new Question(question,answer_one,answer_two,answer_three);
            questionList.add(question1);
        }

        response=new Quiz(quizName,questionList);

        return response;
    }

    private List<QuizEntity> getQuizEntity(){
        return quizRepository.findAll();
    }

    private Optional<List<QuestionQuizEntity>> getQuestionQuizEntity(Long quizId){
        return questionQuizRepository.findAllByQuizId(quizId);
    }

    private Optional<QuestionEntity> getQuestionEntity(Long questionId){
        return questionRepository.findById(questionId);
    }
}
