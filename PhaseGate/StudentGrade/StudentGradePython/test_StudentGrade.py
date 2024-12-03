from unittest import TestCase
from StudentGrade import *

class StudentGradeTest(TestCase):
    def test_get_number_of_students_and_subjects(self):
        result = get_number_of_students_and_subjects(3, 4)
        self.assertEqual(result, [3, 4])
    
    def test_collect_scores(self):
        result = collect_scores([3, 4])
        self.assertEqual(len(result), 3)
        self.assertEqual(len(result[0]), 4)
    
    def test_number_of_passes(self):
        mock_scores = [
            [60, 70, 80],
            [40, 50, 30],
            [55, 65, 45]
        ]
        
        result = number_of_passes(0, mock_scores)
        self.assertEqual(result, [2, 1, 0])

