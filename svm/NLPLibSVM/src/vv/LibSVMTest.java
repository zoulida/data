package vv;


import java.util.Random;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibLINEAR;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

/**
 * @author zhangwei
 *
 */
public class LibSVMTest {

	private Instances m_instances = null;
	private Instances selectedIns;
	
	
	public static void main( String[] args ) throws Exception {
		LibSVMTest filter = new LibSVMTest();
	       
	        filter.getFileInstances( "D:/data/soybean.arff");
	        filter.selectAttUseFilter();
	       
	        filter.selectAttUseMC();
	}
	   
    public void getFileInstances( String fileName ) throws Exception {
        DataSource frData = new DataSource( fileName );
        m_instances = frData.getDataSet();
       
        m_instances.setClassIndex( m_instances.numAttributes() - 1 );
    }
   
    public void selectAttUseFilter() throws Exception {
        AttributeSelection filter = new AttributeSelection();  // package weka.filters.supervised.attribute!
        CfsSubsetEval eval = new CfsSubsetEval();
        GreedyStepwise search = new GreedyStepwise();
        filter.setEvaluator(eval);
        filter.setSearch(search);
        filter.setInputFormat( m_instances );
       
        System.out.println( "number of instance attribute = " + m_instances.numAttributes() );
       
        selectedIns = Filter.useFilter( m_instances, filter);
        System.out.println( "number of selected instance attribute = " + selectedIns.numAttributes() );

        for( int i = 0; i < selectedIns.numInstances(); i++ ) {
           
            System.out.println( selectedIns.instance( i ) );
        }
    }
   
    public void selectAttUseMC() throws Exception {  
         AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
         CfsSubsetEval eval = new CfsSubsetEval();
         GreedyStepwise search = new GreedyStepwise();
         J48 base = new J48();
         NaiveBayes nb = new NaiveBayes();
         LibSVM svm = new LibSVM();
         LibLINEAR linear = new LibLINEAR();
         classifier.setClassifier( svm );
         classifier.setEvaluator( eval );
         classifier.setSearch( search );
         // 10-fold cross-validation
         Evaluation evaluation = new Evaluation( selectedIns );
         evaluation.crossValidateModel(svm, m_instances, 10, new Random(1));
         System.out.println("正确率为：" + (1-evaluation.errorRate()));
         System.out.println( evaluation.toSummaryString());
        
    }

}
